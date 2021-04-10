//json-server --watch data.json -H 0.0.0.0
import 'package:example/view/homepage.dart';
import 'package:example/view/profile.dart';
import 'package:example/view/search.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

const String baseURL = "http://192.168.0.105:3000/";
const String khomeTitleId = "HomePage";
const TextStyle ktabStyle = TextStyle(
    fontSize: 20,
    fontWeight: FontWeight.w600
);
List<Widget>kbottomList = [
  HomePage(),
   Search(),
   Profile(),
];
//userData.when(
//               data: (data)=>ListView.builder(
//                 itemBuilder: (BuildContext context,int index){
//                   return Container(
//                     child: Text(data[index].firstname,style: TextStyle(fontSize: 25),),
//                   );
//                 },
//                 itemCount: data.length,
//               ),
//               error: (error,stack)=>Text("hello"), loading: () { return Text("data");},
//
//             ),



//
// List<Widget>getEmployeeList(AsyncValue<List<Employee>> employeeData,AsyncValue<List<Service>> serviceData,List<Employee> list) {
//   List<Widget> widgets = [];
//   serviceData.when(
//     data: (data) {
//       for (var item in data) {
//         widgets.add(listItems(list));
//       }
//     },
//     error: (error, stack) => widgets.add(Text("hello")),
//     loading: () {
//       widgets.add(Text("hello"));
//     },
//   );
//   return widgets;
// }
// Widget listItems(List<Employee> data){
//   return ListView.builder(
//     itemBuilder: (BuildContext context,int index){
//       return Container(
//         child: Text(data[index].firstname,style: TextStyle(fontSize:20,
//         color: Colors.black),),
//       );
//     },
//     padding: EdgeInsets.symmetric(horizontal: 15,vertical: 8)
//   );
// }