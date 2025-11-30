package net.HM.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.HM.entity.RoomEntity;
import net.HM.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomServ;
	
	@GetMapping
	public List<RoomEntity>getAll(){
		return roomServ.getAll();
	}
	
	@PostMapping
	public ResponseEntity<RoomEntity> saveRoom(@RequestBody RoomEntity room , @RequestParam Long cliententityId ){
	    RoomEntity save =roomServ.saveRoom(cliententityId, room);
	    return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<RoomEntity> findById(@PathVariable Long id){
		Optional<RoomEntity> room = roomServ.findById(id);
		
		if(room.isPresent()) {
			return new ResponseEntity<RoomEntity>(room.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<RoomEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoomEntity> updateById(@PathVariable Long id , @RequestBody RoomEntity room){
	RoomEntity updateRoom =	roomServ.updateById(id, room);
	
		if(updateRoom !=null) {
			return ResponseEntity.ok(updateRoom);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RoomEntity> deleteById(@PathVariable Long id){
		roomServ.deleteById(id);
		return new ResponseEntity<RoomEntity>(HttpStatus.NO_CONTENT);
	}
	
}
