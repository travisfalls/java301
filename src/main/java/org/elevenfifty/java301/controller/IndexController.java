package org.elevenfifty.java301.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.beans.UserImage;
import org.elevenfifty.java301.repository.UserImageRepository;
import org.elevenfifty.java301.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	// @Autowired
	// private Ingredient turkey;
	//
	@GetMapping("")
	public String index(Model model, HttpServletRequest request) {
		// model.addAttribute("turkey", turkey);
		return "index";
	}
	//
	// @GetMapping("/turkey")
	// @ResponseBody
	// public Ingredient jsonEndpoint() {
	// return turkey;
	// }

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserImageRepository userImageRepo;

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "home";
	}

	@GetMapping("/user/{id}")
	public String user(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);
		model.addAttribute("user", u);

		UserImage i = userImageRepo.findByUserId(id);
		model.addAttribute("userImage", i);

		return "user_detail";
	}

	@GetMapping("/user/{id}/edit")
	public String userEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);
		model.addAttribute("user", u);

		return "user_edit";
	}

	@PostMapping("/user/{id}/edit")
	public String userEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid User user,
			BindingResult result, Model model, @RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user_edit";
		} else {

			if (removeImage) {
				//See if the user even has a user image
				UserImage image = userImageRepo.findByUserId(id);
				
				if(image != null) {
					//Remove if it exists
					userImageRepo.delete(image);
					log.info("Image Removed " + id);
				}
				
			} else if (file != null && !file.isEmpty()) {
				try {
					// Load the file into the proper format (Spring does this)

					// Load or create a UserImage
					UserImage image = userImageRepo.findByUserId(user.getId());

					if (image == null) {

						image = new UserImage();
						image.setUserId(id);
					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					// Store in the database
					userImageRepo.save(image);
					
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}

			}
			userRepo.save(user);
			return "redirect:/user/" + user.getId();
		}
	}

}
