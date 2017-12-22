package com.bridgelabz.User.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.User.Service.NoteServices;
import com.bridgelabz.User.Service.UserService;
import com.bridgelabz.User.Utility.Token;
import com.bridgelabz.User.model.CustomeResponse;
import com.bridgelabz.User.model.Note;
import com.bridgelabz.User.model.Response;
import com.bridgelabz.User.model.User;

@RestController
public class NoteController {

	@Autowired
	private NoteServices noteService;

	@Autowired
	private UserService UserService;

	CustomeResponse myResponse = new CustomeResponse();

	@RequestMapping(value = "user/saveNote", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> saveNote(@RequestBody Note note, HttpServletRequest request,
			HttpServletResponse response) {

		//Token tokenObject = new Token();
		String token = request.getHeader("token");
		int id = Token.verify(token);
		User user = UserService.getUserById(id);

		if (user != null) {

			if (id > 0) {

				boolean isActive = user.getActivated();

				if (isActive == true && (note.getTitle().length() > 0 || note.getDescription().length() > 0)) {
					System.out.println("inside notes....");
					note.setUser(user);
					CustomeResponse myResponse = new CustomeResponse();
					Date date = new Date(System.currentTimeMillis());
					note.setCreatedDate(date);
					note.setModifiedDate(date);
					noteService.saveNotes(note);
					myResponse.setMessage("Note is added");
					myResponse.setStatus(1);
					return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);
				}

				myResponse.setMessage("User not Activated ");
				myResponse.setStatus(1);
				return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

			} else

				myResponse.setMessage("Token issue");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

		}
		myResponse.setMessage("Invalid!!!\n Login To Continue");
		myResponse.setStatus(1);
		return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "user/deleteNote/{noteId}", method = RequestMethod.DELETE)
	public ResponseEntity<CustomeResponse> deleteNote(@PathVariable("noteId") int noteId, HttpServletRequest request) {
		System.out.println("id in delete note........" + noteId);

		//Token tokenObject = new Token();
		String token = request.getHeader("token");
		int id = Token.verify(token);
		User user = UserService.getUserById(id);

		if (user != null) {

			noteService.deleteNote(noteId);
			myResponse.setMessage("Note is deleted");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);
		}

		else {

			myResponse.setMessage("Note is Notdeleted");
			myResponse.setStatus(-1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "user/update", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> updateNote(@RequestBody Note note) {
		System.out.println(note);
		CustomeResponse myResponse = new CustomeResponse();
		try {

			System.out.println("in update controller"+note.getTitle() +" " +note.getDescription());

			noteService.updateNote(note);
			myResponse.setMessage("Note is updated");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			myResponse.setMessage("Note is not Updated");
			myResponse.setStatus(-1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/user/getAllNotes", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> getAllNotes(HttpServletRequest request) {

		//Token tokenObject = new Token();
		String token = request.getHeader("token");
		int id = Token.verify(token);
		User user = UserService.getUserById(id);
		List<Note> allNotes = null;

		if (user != null) {

			allNotes = noteService.getallNotes();
			System.out.println(allNotes);
			myResponse.setMessage("Got all the notes");
			myResponse.setStatus(1);
			return new ResponseEntity<List<Note>>(allNotes, HttpStatus.OK);
		}

		else {

			myResponse.setMessage("Got all the notes");
			myResponse.setStatus(1);
			return new ResponseEntity<List<Note>>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/isArchive/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> updateArchive(@PathVariable("noteId") int noteId) {
		CustomeResponse myResponse = new CustomeResponse();
		System.out.println("in archive backend");
		try {
			noteService.updateArchive(noteId);
			myResponse.setMessage("Archive is updated");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			myResponse.setMessage("Archive is not Updated");
			myResponse.setStatus(-1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/emptyTrash/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> UpdateNoteToTrash(@PathVariable("noteId") int noteId) {
		CustomeResponse myResponse = new CustomeResponse();

		System.out.println("in trash backend");

		try {

			noteService.updateTrash(noteId);
			myResponse.setMessage("Trash is updated");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			myResponse.setMessage("Trash is not Updated");
			myResponse.setStatus(-1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/isPin/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> updatePin(@PathVariable("noteId") int noteId,
			@RequestBody boolean isPinned) {
		CustomeResponse myResponse = new CustomeResponse();

		try {
			noteService.updatePin(noteId, isPinned);
			myResponse.setMessage("Pin Updated");
			myResponse.setStatus(1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			myResponse.setMessage("Pin is not Updated");
			myResponse.setStatus(-1);
			return new ResponseEntity<CustomeResponse>(myResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(HttpServletRequest request) {

		Response response = new Response();
		//Token tokenObject = new Token();
		String token = request.getHeader("token");
		int id = Token.verify(token);
		User user = UserService.getUserById(id);

		if (user == null) {
			response.setResponseMessage("User Not Found.....");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setResponseMessage("");
			response.setEmail(user.getEmail());
			response.setFirstName(user.getUserFirstName());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
}

