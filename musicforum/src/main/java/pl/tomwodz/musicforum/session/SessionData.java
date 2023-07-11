package pl.tomwodz.musicforum.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.tomwodz.musicforum.model.User;

@NoArgsConstructor
@Setter
@Getter
@Component
@SessionScope
public class SessionData {
    private User user = null;
    public boolean isLogged(){
        return this.user != null;
    }

    public boolean isAdmin(){
        if(this.user == null){
            return  false;
        }
        return this.user.getRole() == User.Role.ADMIN;
    }

}
