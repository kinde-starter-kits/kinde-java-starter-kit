package com.example.demo.controller;

import org.openapitools.sdk.CallbackController;
import org.openapitools.sdk.KindeClientSDK;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Value("${kinde.host}")
    public String domain;

    @Value("${kinde.redirect.url}")
    public String redirectUri;

    @Value("${kinde.post.logout.redirect.url}")
    public String logoutRedirectUri;

    @Value("${kinde.client.id}")
    public String clientId;

    @Value("${kinde.client.secret}")
    public String clientSecret;

    @Value("${kinde.grant.type}")
    public String grantType;

    @Value("${kinde.scopes}")
    public String scopes;


    KindeClientSDK kindeClientSDK;

    @GetMapping("/")
    public String redirectToFrontendPage(HttpServletRequest request, HttpServletResponse resp, Model model) throws Exception {
        Cookie[] cookies = request.getCookies();
        boolean hasKindeTokenCookie = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("kinde_token".equals(cookie.getName())) {
                    hasKindeTokenCookie = true;
                    Object userDetails=this.kindeClientSDK.getUserDetails(request);
                    model.addAttribute("given_name", ((Map) userDetails)!=null && ((Map) userDetails).containsKey("given_name") ? ((Map) userDetails).get("given_name") : null);
                    model.addAttribute("family_name", ((Map) userDetails)!=null && ((Map) userDetails).containsKey("family_name") ? ((Map) userDetails).get("family_name") : null);
                    model.addAttribute("email", ((Map) userDetails)!=null && ((Map) userDetails).containsKey("email") ? ((Map) userDetails).get("email") : null);

//                    Object token=this.kindeClientSDK.getToken(resp,request);
//                    Object token2=this.kindeClientSDK.getBooleanFlag(request,"is_dark_mode");
//                    Object token2=this.kindeClientSDK.getIntegerFlag(request,"df",false);
//                    Object permissions=this.kindeClientSDK.getPermissions(request);
//                    Object permission=this.kindeClientSDK.getPermission(request,"write");
//                    Object organization=this.kindeClientSDK.getOrganization(request);
//                    Object organization=this.kindeClientSDK.getUserOrganizations(request);
//                    Object feature_flags=this.kindeClientSDK.getFlag(request,"df");
//                    Object feature_flags=this.kindeClientSDK.getFlag(request,"df","s");
                    break;
                }
            }
        }

        // If kinde_token cookie is available, redirect to the frontend page
        if (hasKindeTokenCookie) {
            return "home";
        } else {
            // Redirect to a different page if the cookie is not available
            return "index"; // Replace with the appropriate URL
        }
    }

    @GetMapping("/login")
    public RedirectView login(HttpServletResponse response){
		return (RedirectView) kindeClientSDK.login(response);
    }

    @GetMapping("/register")
    public RedirectView register(HttpServletResponse response){
        return (RedirectView) kindeClientSDK.register(response);
    }

    @GetMapping("/api/auth/kinde_callback")
    public RedirectView callback(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletResponse response, HttpServletRequest request) throws Exception {
        RedirectView redirectView=new CallbackController(this.kindeClientSDK).callback(code,state,response,request);
        return redirectView;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletResponse response){
        RedirectView redirectView=this.kindeClientSDK.logout(response);
        return redirectView;
    }

    @PostConstruct
    public void createKindeClientSDK(){
        this.kindeClientSDK=new KindeClientSDK(
                domain,
                redirectUri,
                clientId,
                clientSecret,
                grantType,
                logoutRedirectUri);
    }
}
