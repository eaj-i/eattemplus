package eajni.project.eattemplus.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    MemberService memberService;

    @GetMapping("/admin")
    public List<Member> getAllMembers(){
        List<Member> members = memberService.getAllMembers();
        return members;
    }
}
