import 'package:dio/dio.dart';
import 'package:example/model/Serivces/employee_dart.dart';
import 'package:example/model/Serivces/service_api.dart';
import 'package:example/model/Serivces/user_api.dart';
import 'package:example/model/core/employee.dart';
import 'package:example/model/core/service.dart';
import 'package:example/model/core/user.dart';
import 'package:example/view/data/bottom_bar_list.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final userprovider = FutureProvider.autoDispose<List<User>>((ref){
  return UserAPi(Dio()).getService();
});
final serviceprovider = FutureProvider.autoDispose<List<Service>>((ref){
  return ServiceApi(Dio()).getService();
});
final employeeprovider = FutureProvider.autoDispose<List<Employee>>((ref) async{
  return EmployeeApi(Dio()).getService();
});
final selectedIndexprovider = StateProvider<int>((ref)=>0);
final loadingProvider = StateProvider<bool>((ref)=>true);
final errorProvider = StateProvider<String>((ref)=>null);
final serviceListProvider = StateProvider<List<Service>>((ref){

  final Listdata = ref.read(serviceprovider);
  return Lists().getSerciveList(Listdata);
});
final employeeListProvider = StateProvider<List<Employee>>((ref)=>[]);