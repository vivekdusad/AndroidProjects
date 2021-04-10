import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:example/constants.dart';
import 'package:example/exception.dart';
import 'package:example/model/core/service.dart';

class ServiceApi{
  ServiceApi(this._dio);
  String url = "http://192.168.0.105:3000/services";
  final Dio _dio;
  Future<List<Service>> getService() async{
    try{
      final response = await _dio.get(url);
      final results = List<Map<String,dynamic>>.from(response.data);
      List<Service> service = results.map((e) => Service.fromJson(e)).toList();
      return service;
    } on DioError catch(e){
      throw ApiException.fromDioError(e);
    }
  }
}
//name
//ui
//cache data store
//pages
//categories
