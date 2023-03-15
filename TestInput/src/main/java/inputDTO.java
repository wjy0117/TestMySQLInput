
public class inputDTO {
    String userid;
    String userpw;
    String userbirth;
    String usergender;
    
    public inputDTO() {
    	
    }
    public inputDTO(String _userid, String _userpw, String _userbirth, String _gender) {
        userid = _userid;
        userpw = _userpw;
        userbirth = _userbirth;
    }
    
    public String getId() {
        return userid;
    }
 
    public void setId(String _userid) {
    	userid = _userid;
    }
 
    public String getPw() {
        return userpw;
    }
 
    public void setPw(String _userpw) {
    	userpw = _userpw;
    }
 
    public String getBirth() {
        return userbirth;
    }
 
    public void setBirth(String _userbirth) {
    	userbirth = _userbirth;
    }
    
    public String getGender() {
        return usergender;
    }
 
    public void setGender(String _usergender) {
    	usergender = _usergender;
    }
    
}