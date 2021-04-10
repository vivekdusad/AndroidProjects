class Service {
  Service(
  {
    this.id,
    this.name,
  }
  );
  final String id;
  final String name;
  factory Service.fromJson(Map<String,dynamic> json){
    return Service(
      id: json['id'],
      name: json['name']
    );
  }
}
