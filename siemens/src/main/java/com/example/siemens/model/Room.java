package com.example.siemens.model;

import com.example.siemens.model.dto.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    public enum Type{
        singleRoom(1), doubleRoom(2), suiteRoom(3), matrimonial(4);
        private final int type;

        Type(int type){
            this.type = type;
        }
        public int getType() {
            return type;
        }
        public static String getTypeName(int type) {
            for (Type t : Type.values()) {
                if (t.getType() == type) {
                    return t.name();
                }
            }
            return null;
        }

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int roomNumber;

    @Column
    private int type;

    @Column
    private int price;

    @Column
    private boolean available;

    @Column
    private LocalDateTime reservationDate;

    public RoomDto toDTO() {
        return new RoomDto(id, roomNumber, Type.getTypeName(type), price, available);
    }

}
