package com.kinde.oauth.controller;

import com.kinde.authorization.AuthorizationUrl;
import com.kinde.oauth.service.KindeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Controller for handling Kinde OAuth-related endpoints and rendering views
 * for various roles and user actions.
 */
@Slf4j
@Controller
public class KindeController {

    private final KindeService kindeService;

    /**
     * Constructor for initializing the controller with the {@link KindeService}.
     *
     * @param kindeService the service used to handle Kinde OAuth operations.
     */
    public KindeController(KindeService kindeService) {
        this.kindeService = kindeService;
    }

    /**
     * Handles requests to the home page.
     *
     * @return the name of the "home" view.
     */
    @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    /**
     * Handles requests to the dashboard page, loading the authenticated user's Kinde profile.
     *
     * @param model the {@link Model} used to pass attributes to the view.
     * @return the name of the "dashboard" view.
     */
    @GetMapping(path = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("kindeUser", kindeService.loadDashboard());
        return "dashboard";
    }

    /**
     * Handles requests to the admin endpoint, restricted to users with the 'admin' role.
     *
     * @return the name of the "admin" view.
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String adminEndpoint() {
        return "admin";
    }

    /**
     * Handles requests to the read endpoint, restricted to users with the 'read' role.
     *
     * @return the name of the "read" view.
     */
    @GetMapping("/read")
    @PreAuthorize("hasRole('read')")
    public String readEndpoint() {
        return "read";
    }

    /**
     * Handles requests to the write endpoint, restricted to users with the 'write' role.
     *
     * @return the name of the "write" view.
     */
    @GetMapping("/write")
    // @PreAuthorize("hasRole('write')")
    public String writeEndpoint() {
        return "write";
    }

    /**
     * Handles requests to the register endpoint, restricted to users with the 'admin' role.
     *
     * @return the url to redirect to for user registration
     */
    @GetMapping("/register")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> register() {
        AuthorizationUrl authorizationUrl = kindeService.register();
        URI redirectUri = URI.create(authorizationUrl.getUrl().toExternalForm());
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectUri)
                .build();
    }

    /**
     * Handles requests to the register endpoint, restricted to users with the 'admin' role.
     *
     * @return the url to redirect to for user registration
     */
    @GetMapping("/create/org/{orgName}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> createOrg(@PathVariable("orgName") String orgName) {
        AuthorizationUrl authorizationUrl = kindeService.createOrg(orgName);
        URI redirectUri = URI.create(authorizationUrl.getUrl().toExternalForm());
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectUri)
                .build();
    }

    /**
     * Handles logout requests to the Kinde service.
     *
     * @return a String representing page to redirect to
     */
    @GetMapping("/signout")
    public ResponseEntity<Void> signout(HttpServletRequest request, HttpServletResponse response) {
        AuthorizationUrl authorizationUrl = kindeService.signout();

        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, null);

        if (authorizationUrl != null) {
            URI redirectUri = URI.create(authorizationUrl.getUrl().toExternalForm());
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(redirectUri)
                    .build();
        } else {
            URI errorPageUri = URI.create("/error");
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(errorPageUri)
                    .build();
        }
    }

}
