import 'package:dio/dio.dart';
import 'package:example/constants.dart';
import 'package:example/model/core/employee.dart';
import '../../exception.dart';
class EmployeeApi{
  EmployeeApi(this._dio);
  String url = baseURL+"employees";
  final Dio _dio;
  Future<List<Employee>> getService() async{
    try{
      final response = await _dio.get(url);
      final results = List<Map<String,dynamic>>.from(response.data);
      List<Employee> service = results.map((e) => Employee.fromJson(e)).toList();
      return service;
    } on DioError catch(e){
      throw ApiException.fromDioError(e);
    }
  }
}