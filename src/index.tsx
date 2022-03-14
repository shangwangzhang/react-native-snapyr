import { NativeModules } from 'react-native';

type SnapyrType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Snapyr } = NativeModules;

export default Snapyr as SnapyrType;
