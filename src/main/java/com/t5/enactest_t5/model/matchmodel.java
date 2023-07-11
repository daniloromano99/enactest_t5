package com.t5.enactest_t5.model;
/*import com.t5.enactest_t5.model.classmodel;
import com.t5.enactest_t5.model.robotmodel;
import com.t5.enactest_t5.model.modelinterfaceclass;
import com.t5.enactest_t5.model.RobotModelInterface;*/

import java.util.UUID;

public class matchmodel implements RobotModelInterface,modelinterfaceclass {
    
    public String robot;
    public int numberclass;
    protected String username;
    private String inviteStatus;
    public String inviteid;
    public String mode;
    private int idmatch;

    @Override
    public String getrobot() {
        return robot;
    }

    @Override
    public void setrobot(String robot) {
        this.robot = robot;
    }


    @Override
    public int getnumberclass(){
        return numberclass;
    }   

    @Override
    public void setnumberclass(int numberclass){

        this.numberclass = numberclass;

    }



    public int getidmatch(){
        return idmatch;
    }

    public void setidmatch(int idmatch){

        this.idmatch = idmatch;

    }

    
    public void setmode(String mode)
    {
        if (mode.equals("singleplayer")) 
            this.mode = "Single Player";
        else if (mode.equals("multiplayer"))
            this.mode = "Multi Player";
        
    }

    public String getmode()
    {
        return mode;
    }

    public matchmodel(){

    }


    public matchmodel(int idmatch,classmodel classmodel,robotmodel robotmodel){

        this.idmatch=idmatch;
        this.robot = robotmodel.getrobot();
        this.numberclass = classmodel.getnumberclass();
    
    }
   
    public void setusername(String username) {
    this.username = username;
    }
  
    public String invitePlayer(String username) {
        String inviteid = UUID.randomUUID().toString();
    return inviteid;
    }

    public String getInviteStatus() {
        return this.inviteStatus;
    }



    public String getInviteResponse(String inviteid) {
        
        String response = "";

        if (getInviteStatus() == "ACCEPTED") {
            response = "SI";
        } else {
            response = "NO";
        }

        return response;
    }

}
