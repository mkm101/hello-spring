package hello.hellospring.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

     private MemberService memberService;
          @Autowired //생성자 호출  스프링이 스프링 컨테이너에 있는 memberservice와 연결
         public MemberController(MemberService memberService)
         {
                          this.memberService = memberService;
             System.out.println("memberService =" + memberService.getClass());

         }

         @GetMapping("/members/new")
          public String createForm(){
              return "members/createMemberForm";
         }

         @PostMapping("/members/new")    // 넘어온 name값을 저장
         public String create(MemberForm form) {
              Member member = new Member();
              member.setName(form.getName());
              memberService.join(member);
              return "redirect:/";   //HOME화면으로 보내는 기능
         }

         @GetMapping("/members")
         public String list(Model model)
         {
             List<Member> members = memberService.findMembers();
             model.addAttribute("members", members);
             return "members/memberList";
         }
}
