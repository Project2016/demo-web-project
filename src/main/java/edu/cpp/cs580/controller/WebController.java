package edu.cpp.cs580.controller;

import java.util.List;
import java.util.Locale;
import com.google.common.base.Optional;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.cpp.cs580.App;
import edu.cpp.cs580.data.User;
import edu.cpp.cs580.data.provider.UserManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {
	/**
	 * This is norah's function.It returns a String "welcome, world"
	 * by default,and you can change "world" to any word. 
	 * type the links:
	 * http://localhost:8080/cs580
	 * http://localhost:8080/cs580?name=User.
	 */
        private static final String template = "Welcome, %s!";
	    @RequestMapping(value="/cs580",method = RequestMethod.GET) 
	    String welcome(@RequestParam(value="name", defaultValue="World") String name) {
	       String message = String.format(template, name);
	       return message;
	        }
	//end norah's function
	    
	 // norah's assignment 4  start:
	    static Logger logger=LoggerFactory.getLogger(WebController.class);
	    
	    public static int sum(int a, int b)
	    {
	    	return a+b;
	    }
	   
	  @RequestMapping(value = "/assignment4norah ", method = RequestMethod.GET)
	public String assignment4(){
		
	
		logger.info(" Welcome this is norah's method");
		int result =sum(8,2);
		System.err.println("result is"+result );
		 String y = Integer.toString(result);
		return  "Welcome this is norah's method . The result is "+y; 
		
		     
	  }
	
	// norah's assignment 4 end   

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;	

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs580/ping
	 */
	 // First HTTP API return my Name Fatimah ALkhazl
		// with the URL: http://localhost:8080/cs580/fatimah
		@RequestMapping(value = "/cs580/fatimah", method = RequestMethod.GET)
		String Fatimah() {
			return "Fatimah Alkhazl";
			
		}
		//assignment4 for Fatimah 
		
				// with the URL: http://localhost:8080/cs580/fatimah2
		// and http://localhost:8080/cs580/joda
				@RequestMapping(value = "/cs580/fatimah2", method = RequestMethod.GET)
				public String getBirthMonthText(LocalDate dateOfBirth) {
					  return " The current month is : " + dateOfBirth.monthOfYear().getAsText(Locale.ENGLISH);
					}
				public class MyBean {
				    private LocalDate date;
				    private LocalDateTime dateTime;
				 
				    public LocalDate getDate() {
				        return date;
				    }
				 
				    public void setDate(LocalDate date) {
				        this.date = date;
				    }
				 
				    public LocalDateTime getDateTime() {
				        return dateTime;
				    }
				 
				    public void setDateTime(LocalDateTime dateTime) {
				        this.dateTime = dateTime;
				    }
				}
				// if i had more time i would to fix the formate and make it better
				@RequestMapping(value = "/cs580/joda", method = RequestMethod.GET)
				public ResponseEntity joda() {
				    MyBean myBean = new MyBean();
				    myBean.setDate(LocalDate.now());
				    myBean.setDateTime(LocalDateTime.now());
				     
				    return new ResponseEntity<MyBean>(myBean, HttpStatus.OK);
				}
	@RequestMapping(value = "/cs580/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}
	//Fatimah Assignment6 and the test in test folder
	
	@RequestMapping(value = "/cs580/A6", method = RequestMethod.GET)
	public String greet(String name){
		name= "Fatimah";
		return "Hello" + name;
		
	}
    //raveena
	 @RequestMapping(value = "/cs580/winter", method = RequestMethod.GET)
	String Raveena() {
		return "hey I am here";
	}
	
	// this is raveena's function for google guava library 
	 @RequestMapping(value = "/cs580/winter", method = RequestMethod.GET)
		
		 public class GuavaDemo {
			   public  void main(String args[]) {
			      GuavaDemo guavaTester = new GuavaDemo();

			      Integer x =  null;
			      Integer y =  new Integer(10);
			      
			      
			      Optional<Integer> a = Optional.fromNullable(x);
			      
			      
			      Optional<Integer> b = Optional.of(y);		

			      System.out.println(guavaTester.mul(a,b));
			   }

			   public Integer mul(Optional<Integer> a, Optional<Integer> b) {
			      
			      System.out.println("First parameter is present: " + a);

			      System.out.println("Second parameter is present: " + b.isPresent());

			      Integer x = a.or(new Integer(0));	

			      Integer y = b.get();

			     
				return x*y;
			   }	
			}
			
	 
   // end of raveena's method 
	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 *
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs580/user/user101
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs580/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs580/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs580/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
		
	}

}