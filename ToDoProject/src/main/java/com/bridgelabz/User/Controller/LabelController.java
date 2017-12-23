/*package com.bridgelabz.User.Controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.User.Service.LabelService;
import com.bridgelabz.User.Service.UserService;
import com.bridgelabz.User.Utility.Token;
import com.bridgelabz.User.model.CustomeResponse;
import com.bridgelabz.User.model.NoteLabel;
import com.bridgelabz.User.model.User;

@RestController
public class LabelController {

	@Autowired
	private UserService UserService;

	@Autowired
	private LabelService labelService;
	CustomeResponse response = new CustomeResponse();

	String token ;
	int id ;

	@RequestMapping(value = "saveLabel", method = RequestMethod.POST)
	public ResponseEntity<CustomeResponse> addlabel(@RequestBody NoteLabel labels ,HttpServletRequest request)
	{
		try {

			if (!(labels.getLabelName() == "" || labels.getLabelName() == null)) {
				NoteLabel labelObj=labelService.getLabelByName(labels.getLabelName());
				if(labelObj == null)
				{
					token = request.getHeader("token");
					id = Token.verify(token);
					User user = UserService.getUserById(id);
					labels.setUser(user);
					labelService.addLabel(labels);
					response.setMessage("label save successfully.....");
					return ResponseEntity.ok(response);
				}
				else{

					response.setMessage("your label is already exist....");
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
				}
			}
			response.setMessage("label can note be empty");
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);		
		}
	}
	@RequestMapping(value = "getLabelNotes/{label}", method = RequestMethod.GET)
	public List<NoteLabel> getLabels(@PathVariable String label, HttpServletRequest request) {


		token = request.getHeader("token");
		id = Token.verify(token);

		User user = UserService.getUserById(id);
		List<NoteLabel> allLabels = labelService.getLabels(user);
		// System.out.println("list of note label "+alNotes);
		return allLabels;
	}
	
	
	
		@RequestMapping(value = "/deleteLabels/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<CustomeResponse> deleteLabel(@PathVariable int id) {
			boolean isDeleted = labelService.deleteLabelById(id);
			if (isDeleted) {
				response.setMessage("deleted successfully");
				return ResponseEntity.ok(response);
			} else {
				response.setMessage("unable to delete");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
	}
		
		@RequestMapping(value = "/editLabel", method = RequestMethod.POST)
		public ResponseEntity<CustomeResponse> editNotes(@RequestBody NoteLabel label, HttpServletRequest request) {

			token = request.getHeader("token");
			id = Token.verify(token);
			User user = UserService.getUserById(id);
			label.setUser(user);
			System.out.println("edited label name " + label.getLabelName());
			boolean isEdited;
			Date resetDate = new Date();
			isEdited = labelService.editLabel(label);
			if (isEdited) {
				response.setMessage(" Notes are edited successfull.....");
				return ResponseEntity.ok(response);
			} else {
				response.setMessage("Notes editing is not possible.....");
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
			}
	}
}







*/