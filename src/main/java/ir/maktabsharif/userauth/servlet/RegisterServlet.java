package ir.maktabsharif.userauth.servlet;

import ir.maktabsharif.userauth.dto.UserDTO;
import ir.maktabsharif.userauth.service.UserService;
import ir.maktabsharif.userauth.service.UserServiceImpl;

import java.io.*;
import java.util.Set;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        UserDTO userDTO = UserDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .username(username)
                .password(password).build();

        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();


        Set<ConstraintViolation<UserDTO>> validate = validator.validate(userDTO);


        for (ConstraintViolation<UserDTO> violation : validate) {
            System.out.println(violation.getMessage());
        }


        if(validate.isEmpty()){
            userService.register(userDTO);
            req.getSession().setAttribute("firstname", firstName);
            req.getRequestDispatcher("/dashboard").forward(req, resp);
        }else {
            req.setAttribute("Error",validate.toArray()[0]);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}