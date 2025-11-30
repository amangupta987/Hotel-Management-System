package net.HM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.HM.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
