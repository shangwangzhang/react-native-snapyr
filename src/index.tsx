import { NativeModules } from 'react-native';

type SnapyrType = {
  identify(identify: string, traits: Record<string, string>): void;
  track(eventName: string, properties: Record<string, string>): void;
  reset(): void;
};

const { Snapyr } = NativeModules;

export default Snapyr as SnapyrType;
