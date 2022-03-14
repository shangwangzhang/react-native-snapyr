import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import Snapyr from 'react-native-snapyr';
export default function App() {
  React.useEffect(() => {
    Snapyr.identify('user id', { email: 'email', name: 'name' });
  }, []);
  return React.createElement(
    View,
    { style: styles.container },
    React.createElement(Text, null, 'Snapyr Identify')
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
