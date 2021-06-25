
import 'package:flutter/material.dart';
import 'package:otp_screen/tile.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  bool value = false;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SettingsList(
          sections: [
            SettingsSection(
              title: 'General',
              tiles: [
                SettingsTile(
                  title: 'Language',
                  subtitle: 'English',
                  leading: Icon(Icons.language),
                  onPressed: (BuildContext context) {},
                ),
                SettingsTile.switchTile(
                  title: 'Dark Mode',
                  leading: Icon(Icons.dark_mode),
                  switchValue: value,
                  onToggle: (bool value) {},
                ),
              ],
            ),
            SettingsSection(
              title: 'Account',
              tiles: [
                SettingsTile(
                  title: 'Edit Profile',

                  leading: Icon(Icons.person),
                  onPressed: (BuildContext context) {},
                ),
                SettingsTile(title: 'Change Password',
                leading: Icon(Icons.lock),),
                SettingsTile(title: "Logout",leading: Icon(Icons.logout),)

              ],
            ),
          ],
        ),
      ),
    );
  }
}
//import 'package:flutter/foundation.dart';
// import 'package:flutter/material.dart';
// import 'package:flutter/widgets.dart';
//
//
//
// const Color mediumGrayColor = Color(0xFFC7C7CC);
// const Color itemPressedColor = Color(0xFFD9D9D9);
// const Color borderColor = Color(0xFFBCBBC1);
// const Color borderLightColor = Color.fromRGBO(49, 44, 51, 1);
// const Color backgroundGray = Color(0xFFEFEFF4);
// const Color groupSubtitle = Color(0xFF777777);
// const Color iosTileDarkColor = Color.fromRGBO(28, 28, 30, 1);
// const Color iosPressedTileColorDark = Color.fromRGBO(44, 44, 46, 1);
// const Color iosPressedTileColorLight = Color.fromRGBO(230, 229, 235, 1);
//
// const defaultTitlePadding = EdgeInsets.only(
//   left: 15.0,
//   right: 15.0,
//   bottom: 6.0,
// );
// enum _SettingsTileType { simple, switchTile }
//
// class SettingsTile extends StatelessWidget {
//   final String title;
//   final int titleMaxLines;
//   final String subtitle;
//   final int subtitleMaxLines;
//   final Widget leading;
//   final Widget trailing;
//   final Icon iosChevron;
//   final EdgeInsetsGeometry iosChevronPadding;
//   final VoidCallback onTap;
//   final Function(BuildContext context) onPressed;
//   final Function(bool value) onToggle;
//   final bool switchValue;
//   final bool enabled;
//   final TextStyle titleTextStyle;
//   final TextStyle subtitleTextStyle;
//   final Color switchActiveColor;
//   final _SettingsTileType _tileType;
//
//    SettingsTile({
//     Key key,
//     @required this.title,
//     this.titleMaxLines,
//     this.subtitle,
//     this.subtitleMaxLines,
//     this.leading,
//     this.trailing,
//
//     @Deprecated('Use onPressed instead') this.onTap,
//     this.titleTextStyle,
//     this.subtitleTextStyle,
//     this.enabled = true,
//     this.onPressed,
//     this.switchActiveColor, this.iosChevron, this.iosChevronPadding,
//   })  : _tileType = _SettingsTileType.simple,
//         onToggle = null,
//         switchValue = null,
//         assert(titleMaxLines == null || titleMaxLines > 0),
//         assert(subtitleMaxLines == null || subtitleMaxLines > 0),
//         super(key: key);
//
//   const SettingsTile.switchTile({
//     Key key,
//     @required this.title,
//     this.titleMaxLines,
//     this.subtitle,
//     this.subtitleMaxLines,
//     this.leading,
//     this.enabled = true,
//     this.trailing,
//     @required this.onToggle,
//     @required this.switchValue,
//     this.titleTextStyle,
//     this.subtitleTextStyle,
//     this.switchActiveColor,
//   })  : _tileType = _SettingsTileType.switchTile,
//         onTap = null,
//         onPressed = null,
//         iosChevron = null,
//         iosChevronPadding = null,
//         assert(titleMaxLines == null || titleMaxLines > 0),
//         assert(subtitleMaxLines == null || subtitleMaxLines > 0),
//         super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     final platform = Theme.of(context).platform;
//         return androidTile(context);
//     }
//
//
//
//
//   Widget androidTile(BuildContext context) {
//     if (_tileType == _SettingsTileType.switchTile) {
//       return SwitchListTile(
//         secondary: leading,
//         value: switchValue,
//         activeColor: switchActiveColor,
//         onChanged: enabled ? onToggle : null,
//         title: Text(
//           title,
//           style: titleTextStyle,
//           maxLines: titleMaxLines,
//           overflow: TextOverflow.ellipsis,
//         ),
//         subtitle: subtitle != null
//             ? Text(
//           subtitle,
//           style: subtitleTextStyle,
//           maxLines: subtitleMaxLines,
//           overflow: TextOverflow.ellipsis,
//         )
//             : null,
//       );
//     } else {
//       return ListTile(
//         title: Text(title, style: titleTextStyle),
//         subtitle: subtitle != null
//             ? Text(
//           subtitle,
//           style: subtitleTextStyle,
//           maxLines: subtitleMaxLines,
//           overflow: TextOverflow.ellipsis,
//         )
//             : null,
//         leading: leading,
//         enabled: enabled,
//         trailing: trailing,
//         onTap: onTapFunction(context) as void Function(),
//       );
//     }
//   }
//
//   Function onTapFunction(BuildContext context) =>
//       onTap != null || onPressed != null
//           ? () {
//         if (onPressed != null) {
//           onPressed.call(context);
//         } else {
//           onTap.call();
//         }
//       }
//           : null;
// }
// abstract class AbstractSection extends StatelessWidget {
//   bool showBottomDivider = false;
//   final String title;
//   final EdgeInsetsGeometry titlePadding;
//
//   AbstractSection({Key key, this.title, this.titlePadding}) : super(key: key);
// }
// // ignore: must_be_immutable
// class SettingsSection extends AbstractSection {
//   final List<SettingsTile> tiles;
//   final TextStyle titleTextStyle;
//   final int maxLines;
//   final Widget subtitle;
//   final EdgeInsetsGeometry subtitlePadding;
//
//   SettingsSection({
//     Key key,
//     String title,
//     EdgeInsetsGeometry titlePadding = defaultTitlePadding,
//     this.maxLines,
//     this.subtitle,
//     this.subtitlePadding = defaultTitlePadding,
//     this.tiles,
//     this.titleTextStyle,
//   })  : assert(maxLines == null || maxLines > 0),
//         super(key: key, title: title, titlePadding: titlePadding);
//
//   @override
//   Widget build(BuildContext context) {
//     final platform = Theme.of(context).platform;
//
//     return androidSection(context);
//
//
//     }
//
//
//
//
//   Widget androidSection(BuildContext context) {
//     return Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
//       if (title != null)
//         Padding(
//           padding: titlePadding,
//           child: Text(
//             title,
//             style: titleTextStyle ??
//                 TextStyle(
//                   color: Theme.of(context).accentColor,
//                   fontWeight: FontWeight.bold,
//                 ),
//             maxLines: maxLines,
//             overflow: TextOverflow.ellipsis,
//           ),
//         ),
//       if (subtitle != null)
//         Padding(
//           padding: subtitlePadding,
//           child: subtitle,
//         ),
//       ListView.separated(
//         physics: NeverScrollableScrollPhysics(),
//         shrinkWrap: true,
//         itemCount: tiles.length,
//         separatorBuilder: (BuildContext context, int index) =>
//             Divider(height: 1),
//         itemBuilder: (BuildContext context, int index) {
//           return tiles[index];
//         },
//       ),
//       if (showBottomDivider) Divider(height: 1)
//     ]);
//   }
// }
// class SettingsList extends StatelessWidget {
//   final bool shrinkWrap;
//   final ScrollPhysics physics;
//   final List<AbstractSection> sections;
//   final Color backgroundColor;
//   final Color lightBackgroundColor;
//   final Color darkBackgroundColor;
//   final EdgeInsetsGeometry contentPadding;
//
//   const SettingsList({
//     Key key,
//     this.sections,
//     this.backgroundColor,
//     this.physics,
//     this.shrinkWrap = false,
//     this.lightBackgroundColor,
//     this.darkBackgroundColor,
//     this.contentPadding,
//   }) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     return Material(
//       child: Ink(
//         color: Theme.of(context).brightness == Brightness.light
//             ? backgroundColor ?? lightBackgroundColor ?? backgroundGray
//             : backgroundColor ?? darkBackgroundColor ?? Colors.black,
//         child: ListView.builder(
//           physics: physics,
//           shrinkWrap: shrinkWrap,
//           padding: contentPadding,
//           itemCount: sections.length,
//           itemBuilder: (context, index) {
//             AbstractSection current = sections[index];
//             AbstractSection futureOne;
//             if (index + 1 != sections.length) {
//               futureOne = sections[index + 1];
//             }
//
//             // Add divider if title is null
//             if (futureOne != null && futureOne.title != null) {
//               current.showBottomDivider = false;
//               return current;
//             } else {
//               current.showBottomDivider = true;
//               return current;
//             }
//           },
//         ),
//       ),
//     );
//   }
// }
