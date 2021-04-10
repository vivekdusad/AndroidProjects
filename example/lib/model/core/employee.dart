

class Employee {
  Employee(
  {
    this.firstname,
    this.lastname,
    this.mobileNumber,
    this.location,
    this.email,
    this.username,
    this.password,
    this.role,
    this.services,
    this.isAvailable,
    this.rating,
    this.photoURL,
    this.createdBy,
  }
  );
  final String firstname;
  final String lastname;
  final String mobileNumber;
  final String location;
  final String email;
  final String username;
  final String password;
  final String role;
  final List<String> services;
  final bool isAvailable;
  final double rating;
  final String photoURL;
  final String createdBy;

  factory Employee.fromJson(Map<String,dynamic> jsonData) {
    return Employee(
      firstname: jsonData["firstname"],
      lastname: jsonData["lastname"],
      mobileNumber: jsonData["mobileNumber"],
      email: jsonData["email"],
      username: jsonData["username"],
      password: jsonData["password"],
      role: jsonData["role"],
      createdBy: jsonData["createdBy"],
      photoURL: jsonData["photoURL"],
      rating: jsonData["rating"],
      services: jsonData["services"],
      location: jsonData["location"],
      isAvailable: jsonData["isAvailable"],
    );
  }
}
