package com.t5.enactest_t5;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.t5.enactest_t5.model.classmodel;
import com.t5.enactest_t5.model.matchmodel;
import com.t5.enactest_t5.model.robotmodel;


 

@RestController
public class restcontroller {

    private List<classmodel> list;
    private List<robotmodel> list_robot;
    private List<matchmodel> list_match;
    private int idmatch=0;
    String copyrobot;
    int copynumberclass;
    String username;
   

    public restcontroller(){

        list = new ArrayList<classmodel>();   //lista delle classi
        list_robot = new ArrayList<robotmodel>();  //lista dei robot
        list_match = new ArrayList<matchmodel>();

    }
    
    @RequestMapping("/api/chooseclass")
    public Iterable<classmodel> getclass(){

        return list;

    }

    @RequestMapping("/api/chooserobot")
    public Iterable<robotmodel> getrobot(){

        return list_robot;

    }

    @RequestMapping("/api/choosematch")
    public Iterable<matchmodel> getmatch(){
        return list_match;
    }
    /*@PostMapping("/admin/api/chooseclass")
    public classmodel create(@RequestBody classmodel class){



    }*/
    
     
     
    @RequestMapping("/api/chooseclass/{numberclass}")
    public classmodel getbyId(@PathVariable int numberclass){ 

        Optional<classmodel> classmodel = list.stream().filter(item->item.getnumberclass() == numberclass).findFirst();

        if(classmodel.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        
        }        
        
        return classmodel.get();

    }

    @RequestMapping(value = "/api/createclass/{classid}", method = RequestMethod.POST)
    public classmodel create (@PathVariable int classid,@RequestBody classmodel classmodel){

        classmodel.setnumberclass(classid);
        copynumberclass=classid;

        list.add(classmodel);

        return classmodel;

    }
    


    @RequestMapping("/api/chooserobot/{robot}")
    public robotmodel getRobotmodel(@PathVariable String robot){ 

    Optional<robotmodel> robotmodel = list_robot.stream().filter(item->item.getrobot().equals(robot)).findFirst();

        if(robotmodel.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        
        }
    

        return robotmodel.get();
        
    }

    @RequestMapping("/api/choosematch/{matchid}")
    public matchmodel getMatchModel(@PathVariable int matchid){ 

    Optional<matchmodel> matchmodel = list_match.stream().filter(item->item.getidmatch() == matchid).findFirst();

        if(matchmodel.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        
        }
    

        return matchmodel.get();
        
    }    

    @RequestMapping(value = "/api/createrobot/{robot}", method = RequestMethod.POST)
    public robotmodel createrobot (@PathVariable String robot,@RequestBody robotmodel robotmodel){

        robotmodel.setrobot(robot);

        copyrobot=robot;

        list_robot.add(robotmodel);

        return robotmodel;

    }

    @RequestMapping(value="/api/creatematch", method = RequestMethod.POST)
    public matchmodel creatematch (classmodel classmodelinstance, robotmodel robotmodelinstance){
        /*idmatch++;
        matchmodel m = new matchmodel();

        m.setrobot(robot);
        m.setidmatch(idmatch);
        m.setnumberclass(numberclass);
        list_match.add(m);

        return m;*/
    idmatch++;
    

    if (list_robot.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No robots available");
    }

    if (list.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No classes available");
    }


    matchmodel match = new matchmodel();

    match.setidmatch(idmatch);
    match.setrobot(copyrobot);
    match.setnumberclass(copynumberclass);

    list_match.add(match);

    return match;
    }

        
      
      @RequestMapping(value="/api/invite_player", method = RequestMethod.POST)
        public matchmodel InvitaGiocatore(@PathVariable String username) {
 
                matchmodel match = new matchmodel();

                match.setusername(username);

               match.inviteid = match.invitePlayer(username);
                
                return match;
            }
             
            @RequestMapping(value="/api/ricezione_player", method = RequestMethod.GET)
                public String RicezioneInvito (String inviteid) {
                
                    matchmodel match = new matchmodel();
    
                    String response = match.getInviteResponse(inviteid);

                    return response;
                }

            @RequestMapping(value = "/api/choosemode/{mode}", method = RequestMethod.POST)
                public matchmodel setMatchModel(@PathVariable String mode) {
                    matchmodel match = new matchmodel();
                    match.setmode(mode);
                    return match;
                }
                
}




