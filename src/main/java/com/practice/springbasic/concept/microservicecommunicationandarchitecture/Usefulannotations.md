`@RestController`	 Marks a class as a REST controller. Combines @Controller + @ResponseBody.


`@Service`	Marks a class as part of the business/service layer.
`@Repository`	Marks a class as a Data Access Object (DAO).
`@Component`	Generic stereotype annotation for Spring-managed beans.
`@Autowired`	Enables dependency injection by type (constructor, field, or setter).


# @Controller
Used for MVC web applications.
Returns views (HTML/JSP pages).
If you return a string, Spring treats it as a view name.
To return JSON, you must add @ResponseBody manually.
example:
1.              @Controller
                public class HelloController {
                
                    @GetMapping("/hello")
                    @ResponseBody
                    public String sayHello() {
                        return "Hello World"; // Returned as text/JSON directly
                    }
                }
2.              @Controller
                public class PageController {
                
                    @GetMapping("/home")
                    public String homePage() {
                        return "home"; // Spring will look for home.html or home.jsp
                    }
                }

   
# @RestController
Used for REST APIs.
Returns JSON/XML directly.
It is basically: @Controller + @ResponseBody
So @RestController auto-converts return values into JSON, while @Controller is for serving web pages.
