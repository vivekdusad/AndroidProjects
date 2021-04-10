import 'dart:convert';
import 'dart:developer';
import 'package:dio/dio.dart';
import 'package:example/constants.dart';
import 'package:example/model/core/user.dart';
import 'package:http/http.dart' as http;

import '../../exception.dart';


class UserAPi{
  UserAPi(this._dio);
  String url = baseURL+"users";
  final Dio _dio;
  Future<List<User>> getService() async{
    try{
      final response = await _dio.get(url);
      final results = List<Map<String,dynamic>>.from(response.data);
      List<User> user = results.map((e) => User.fromJson(e)).toList();
      return user;
    } on DioError catch(e){
      throw ApiException.fromDioError(e);
    }
  }
}

