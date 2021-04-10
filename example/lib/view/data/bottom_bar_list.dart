import 'dart:developer';

import 'package:example/model/core/employee.dart';
import 'package:example/model/core/service.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class Lists{
  List<Service> getSerciveList(AsyncValue<List<Service>> Listdata) {
    List<Service> widgets = [];
    Listdata.when(
      data: (data) {
        for (var item in data) {
          widgets.add(item);
        }
      },
      error: (error, stack) => widgets=null,
      loading: () {},
    );
    return widgets;
  }
  List<Employee> getEmployeeList(AsyncValue<List<Employee>> Listdata) {
    List<Employee> widgets = [];
    Listdata.when(
      data: (data) {
        for (var item in data) {
          widgets.add(item);
        }
      },
      error: (error, stack) => widgets=null,
      loading: () {},
    );
    return widgets;
  }
}