# Usa una immagine di base contenente Maven e JDK di OpenJDK
FROM maven:3.8.1-openjdk-11-slim AS builder

# Copia il codice sorgente nella directory di lavoro del container
WORKDIR /src
COPY /src

# Compila il progetto utilizzando Maven
RUN mvn clean package

# Utilizza un'immagine di base leggera con JRE di OpenJDK
FROM adoptopenjdk:11-jre-hotspot AS runner

# Imposta la directory di lavoro nel container
WORKDIR /src

# Copia il file JAR compilato dalla fase precedente
COPY --from=builder /target/enactest_t5-0.0.1-SNAPSHOT.jar /src

# Esegui il file JAR quando il contenitore viene avviato
CMD ["java", "-jar", "enactest_t5-0.0.1-SNAPSHOT.jar"]
