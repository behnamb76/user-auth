package ir.maktabsharif.userauth.servlet;

import ir.maktabsharif.userauth.model.User;
import ir.maktabsharif.userauth.service.UserService;
import ir.maktabsharif.userauth.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/dashboard")
public class AuthFilter implements Filter {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> optionalUser = userService.getUserByUsernameAndPassword(username, password);
        HttpSession session = ((HttpServletRequest)req).getSession();

        if (optionalUser.isPresent()) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("firstname", optionalUser.get().getFirstName());
            filterChain.doFilter(req, resp);
        } else if (session != null && session.getAttribute("username") != null) {
            filterChain.doFilter(req, resp);
        } else {
            req.setAttribute("message", "Invalid username or password");
            RequestDispatcher rq = req.getRequestDispatcher("/login.jsp");
            rq.forward(req, resp);
        }
    }
}
