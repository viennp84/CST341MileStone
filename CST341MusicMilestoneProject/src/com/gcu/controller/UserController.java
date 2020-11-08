package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DataAccessInterface;
import com.gcu.business.SecurityInterface;
import com.gcu.model.Album;
import com.gcu.model.Artist;
import com.gcu.model.Genre;
import com.gcu.model.User;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/03/2020
 * User controller
 * User Controller will call the activities that responses for user business.
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	/*Initialize DataAccessService dependency injection*/
	DataAccessInterface<User> dataAccessService;
	
	/*Initialize securityService dependency injection*/
	SecurityInterface<User> securityService;
	
	/*Initialize ArtistDataAccessService dependency injection*/
	DataAccessInterface<Artist> artistDataAccessService;
	
	/*Initialize GenreDataAccessService dependency injection*/
	DataAccessInterface<Genre> genreDataAccessService;
	
	/*Initialize AlbumDataAccessService dependency injection*/
	DataAccessInterface<Album> albumDataAccessService;
	

	public void setAlbumDataAccessService(DataAccessInterface<Album> albumDataAccessService) {
		this.albumDataAccessService = albumDataAccessService;
	}

	public void setGenreDataAccessService(DataAccessInterface<Genre> genreDataAccessService) {
		this.genreDataAccessService = genreDataAccessService;
	}

	public void setArtistDataAccessService(DataAccessInterface<Artist> artistDataAccessService) {
		this.artistDataAccessService = artistDataAccessService;
	}

	public void setDataAccessService(DataAccessInterface<User> dataAccessService) {
		this.dataAccessService = dataAccessService;
	}

	public void setSecurityService(SecurityInterface<User> securityService) {
		this.securityService = securityService;
	}
	
	/*Display the form for creating artist*/
	@RequestMapping(path = "/addArtistForm", method = RequestMethod.GET)
	public ModelAndView displayArtistForm() {

		ModelAndView modelAndView = new ModelAndView("addArtist", "artist", new Artist());
		return modelAndView;
	}
	/*Creating artist*/
	@RequestMapping(path = "/viewArtists", method = RequestMethod.GET)
	public ModelAndView addArtist() {
		List<Artist> artists=artistDataAccessService.findAll();
			return new ModelAndView("displayArtist", "artists", artists);
	}
	/*Creating artist*/
	@RequestMapping(path = "/addArtist", method = RequestMethod.POST)
	public ModelAndView addArtist(@Valid@ModelAttribute("artist") Artist artist, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addArtist", "artist", artist);
		}/* Check if the artist is created */
		boolean isCreated = artistDataAccessService.create(artist);
		if(isCreated) {
		List<Artist> artists=artistDataAccessService.findAll();
			return new ModelAndView("displayArtist", "artists", artists);
		}
		else
			return new ModelAndView("addArtist","artist",artist);
	}
	/*Delete artist*/
	@RequestMapping(path = "/deleteArtist/{id}", method = RequestMethod.GET)
	public ModelAndView deleteArtist(@PathVariable int id, Artist artist) {

		/* Check if the artist is deleted */
		boolean isDeleted = artistDataAccessService.deleteId(id);
		if(isDeleted) {
		List<Artist> artists=artistDataAccessService.findAll();
			return new ModelAndView("displayArtist", "artists", artists);
		}
		else
			return new ModelAndView("error","artist",artist);
	}
	/*Edit artist*/
	@RequestMapping(path = "/updateArtist/{id}", method = RequestMethod.GET)
	public ModelAndView updateArtist(@PathVariable int id, Artist artist) {

		/* get artist by id and return it to the view */
		
		Artist result = artistDataAccessService.findById(id);
		return new ModelAndView("updateArtist", "artist", result);
	
	}
	/*save edit artist*/
	@RequestMapping(value="/saveUpdateArtist", method = RequestMethod.POST)
	public ModelAndView saveUpdateArtist(@ModelAttribute("artist") Artist artist) {
		
		/* Check if the artist is changed */
		boolean isEdited = artistDataAccessService.update(artist);
		if(isEdited) {
		List<Artist> artists=artistDataAccessService.findAll();
			return new ModelAndView("displayArtist", "artists", artists);
		}
		else
			return new ModelAndView("error","artist",artist);
	}
	

	/*Display the form for user register*/
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView displayForm() {

		ModelAndView modelAndView = new ModelAndView("addUser", "user", new User());
		return modelAndView;
	}

	/* Add user by calling the create user business */
	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid@ModelAttribute("user") User user, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addUser", "user", user);
		}/* Check if the User is created */
		boolean isRegistered = dataAccessService.create(user);
		if(isRegistered)
			return new ModelAndView("welcome", "user", user);
		else
			return new ModelAndView("addUserFailed","user",user);

	}
	/*Display login form for user*/
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {

		ModelAndView modelAndView = new ModelAndView("login", "user", new User());
		return modelAndView;
	}

	/* User login calling the login business */
	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@Valid@ModelAttribute("user") User user, BindingResult result) {
		/* Check if the User is created */
		
		if (result.hasErrors()) 
			return new ModelAndView("login", "user", user);
		
		boolean isValid = securityService.login(user);
		if(isValid)
			return new ModelAndView("welcome", "user", user);
		else
			return new ModelAndView("loginFailed","user",user);
	}
	
	/*Display the form for creating genre*/
	@RequestMapping(path = "/addGenreForm", method = RequestMethod.GET)
	public ModelAndView displayGenreForm() {

		ModelAndView modelAndView = new ModelAndView("addGenre", "genre", new Genre());
		return modelAndView;
	}
	/*Creating genre*/
	@RequestMapping(path = "/viewGenres", method = RequestMethod.GET)
	public ModelAndView addGenre() {
		List<Genre> genres=genreDataAccessService.findAll();
			return new ModelAndView("displayGenre", "genres", genres);
	}
	/*Creating genre*/
	@RequestMapping(path = "/addGenre", method = RequestMethod.POST)
	public ModelAndView addGenre(@Valid@ModelAttribute("genre") Genre genre, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addGenre", "genre", genre);
		}/* Check if the genre is created */
		boolean isCreated = genreDataAccessService.create(genre);
		if(isCreated) {
		List<Genre> genres=genreDataAccessService.findAll();
			return new ModelAndView("displayGenre", "genres", genres);
		}
		else
			return new ModelAndView("addGenre","genre",genre);
	}
	/*Delete genre*/
	@RequestMapping(path = "/deleteGenre/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGenre(@PathVariable int id, Genre genre) {

		/* Check if the genre is deleted */
		boolean isDeleted = genreDataAccessService.deleteId(id);
		if(isDeleted) {
			List<Genre> genres=genreDataAccessService.findAll();
			return new ModelAndView("displayGenre", "genres", genres);
		}
		else
			return new ModelAndView("error","genre",genre);
	}
	/*Display the form for creating album*/
	@RequestMapping(path = "/addAlbumForm", method = RequestMethod.GET)
	public ModelAndView displayAlbumForm() {

		ModelAndView modelAndView = new ModelAndView("addAlbum", "album", new Album());
		return modelAndView;
	}
	/*View Album*/
	@RequestMapping(path = "/viewAlbums", method = RequestMethod.GET)
	public ModelAndView addAlbum() {
		List<Album> albums=albumDataAccessService.findAll();
			return new ModelAndView("displayAlbum", "albums", albums);
	}
	/*Creating Album*/
	@RequestMapping(path = "/addAlbum", method = RequestMethod.POST)
	public ModelAndView addAlbum(@Valid@ModelAttribute("album") Album album, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addAlbum", "album", album);
		}/* Check if the album is created */
		boolean isCreated = albumDataAccessService.create(album);
		if(isCreated) {
		List<Album> albums=albumDataAccessService.findAll();
			return new ModelAndView("displayAlbum", "albums", albums);
		}
		else
			return new ModelAndView("addAlbum","album",album);
	}
	/*Delete Album*/
	@RequestMapping(path = "/deleteAlbum/{id}", method = RequestMethod.GET)
	public ModelAndView deleteAlbum(@PathVariable int id, Album album) {

		/* Check if the album is deleted */
		boolean isDeleted = albumDataAccessService.deleteId(id);
		if(isDeleted) {
			List<Album> albums=albumDataAccessService.findAll();
			return new ModelAndView("displayAlbum", "albums", albums);
		}
		else
			return new ModelAndView("error","album",album);
	}
}
