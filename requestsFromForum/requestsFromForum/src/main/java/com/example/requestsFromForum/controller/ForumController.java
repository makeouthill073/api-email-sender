package com.example.requestsFromForum.controller;

import com.example.requestsFromForum.dto.ClientDTO;
import com.example.requestsFromForum.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/api/email/sender")
public class ForumController {

    EmailSenderService emailSenderService;

    @Autowired
    public ForumController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/mbusiness")
    public String clientInfoFromBusiness(@ModelAttribute("clients") @Valid ClientDTO clientDTO,
                             BindingResult bindingResult) throws IOException, MessagingException {
        if (bindingResult.hasErrors())
            return "forum/errorPage";

        clientDTO.setMbusiness("mbusiness");

        emailSenderService.sendmail(clientDTO);

        return "forum/completePage";
    }

    @PostMapping("/mstroy")
    public String clientInfoFromMstroy(@ModelAttribute("clients") @Valid ClientDTO clientDTO,
                                       BindingResult bindingResult) throws IOException, MessagingException {
        if (bindingResult.hasErrors())
            return "forum/errorPage";

        clientDTO.setMstroy("mstroy");

        emailSenderService.sendmail(clientDTO);

        return "forum/completePage";
    }

    @PostMapping("/mlogic")
    public String clientInfoFromMlogic(@ModelAttribute("clients") @Valid ClientDTO clientDTO,
                                       BindingResult bindingResult) throws IOException, MessagingException {
        if (bindingResult.hasErrors())
            return "forum/errorPage";

        clientDTO.setMlogic("mlogic");

        emailSenderService.sendmail(clientDTO);

        return "forum/completePage";
    }
}
