package LibTrackModel;

public class modelU {
    private String email;
    private String password;
    private String role;

    public modelU(String email, String password, String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public boolean login(String InputPassword){
        return password.equals(InputPassword);
    }

    public String getEmail(){
        return email;
    }
}
