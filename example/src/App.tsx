import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import Snapyr from 'react-native-snapyr';

export default function App() {
  React.useEffect(() => {
    Snapyr.identify('user id', { email: 'email', name: 'name' });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Snapyr Identify</Text>
    </View>
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
