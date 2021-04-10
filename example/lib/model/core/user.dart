import 'package:flutter/material.dart';
import 'package:json_annotation/json_annotation.dart';


class User {
  User(
  {
    this.firstname,
    this.lastname,
    this.mobileNumber,
    this.email,
    this.username,
    this.password,
    this.isActive,
    this.role,
    this.createdBy,
    this.photoURL,
}
  );
  final String firstname;
  final String lastname;
  final String mobileNumber;
  final String email;
  final String username;
  final String password;
  final String role;
  final String createdBy;
  final String photoURL;
  final bool isActive;
//TODO:Serialization of json using external libraries for production level
//   https://flutter.dev/docs/development/data-and-backend/json
   factory User.fromJson(Map<String,dynamic> jsonData){
    return User(
      firstname: jsonData["firstname"],
      lastname: jsonData["lastname"],
      mobileNumber: jsonData["mobileNumber"],
      email: jsonData["email"],
      username: jsonData["username"],
      password: jsonData["password"],
      role: jsonData["role"],
      createdBy: jsonData["createdBy"],
      photoURL: jsonData["photoURL"],
      isActive: jsonData["isActive"],
    );
  }
  Map<String,dynamic> toJson()=>{
    'firstname':firstname,
    'lastname':lastname,
    "mobileNumber":mobileNumber,
    "email":email,
    "username":username,
    "password":password,
    "role":role,
    "createdBy": createdBy,
    "photoURL":photoURL,
    "isActive":isActive
  };
}
