package net.HM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.HM.entity.ClientEntity;
import net.HM.entity.RoomEntity;
import net.HM.repository.ClientRepository;
import net.HM.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	
	public List<RoomEntity> getAll(){
		return roomRepo.findAll();
	}
	
	public RoomEntity saveRoom(Long cliententityId , RoomEntity room) {
		ClientEntity cliententity = clientRepo.findById(cliententityId).orElse(null);
		
		if(cliententity !=null) {
			room.setCliententity(cliententity);
			
			room.setRoomNumber(room.getRoomNumber());
			return roomRepo.save(room);
		}
		return null;
	}
	
	public Optional<RoomEntity> findById(Long id){
		return roomRepo.findById(id);
	}
	
	public RoomEntity updateById(Long id , RoomEntity room) {
		RoomEntity existingRoom = roomRepo.findById(id).orElse(null);
		
		existingRoom.setRoomNumber(room.getRoomNumber());
		existingRoom.setAvailable(room.getAvailable());
		existingRoom.setPricePerNight(room.getPricePerNight());
		
		return roomRepo.save(existingRoom);
	}
	
	public void deleteById(Long id) {
		roomRepo.deleteById(id);
	}
}
