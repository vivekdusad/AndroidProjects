import 'package:example/constants.dart';
import 'package:example/provider/providers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
void main() {
  runApp(ProviderScope(child: MyApp()));
}
class MyApp extends ConsumerWidget {
  @override
  Widget build(BuildContext context,ScopedReader watch) {
    final _selectedIndex= watch(selectedIndexprovider);

    // final serviceList = watch(serviceListProvider);
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: kbottomList[_selectedIndex.state],
        bottomNavigationBar:BottomNavigationBar(
          items: [
            BottomNavigationBarItem(icon: Icon(Icons.home),label: "Home"),
            BottomNavigationBarItem(icon: Icon(Icons.search),label: "Search"),
            BottomNavigationBarItem(icon: Icon(Icons.person),label: "Profile"),
          ],
          onTap: (number){
          if(number==0){
            _selectedIndex.state = 0;
            }
          if(number ==1){
            _selectedIndex.state = 1;
            }
          if(number==2){
            _selectedIndex.state = 2;
            }
          },
          currentIndex: _selectedIndex.state,
        ),
      ),
    );
  }
}

