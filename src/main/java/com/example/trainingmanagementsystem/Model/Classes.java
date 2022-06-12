package com.example.trainingmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classes {

    Long id;

    String topic;

    Date date;

    List<Notification> notificationList;

    List<User> userList;
}
