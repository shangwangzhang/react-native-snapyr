#import "Snapyr.h"
#import <Snapyr/Snapyr.h>

@implementation Snapyr

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(identify:(NSString *)identify traits:(NSDictionary *)traits)
{
  if (identify) {
    [[SnapyrSDK sharedSDK] identify:identify traits:traits];
  }
}

RCT_EXPORT_METHOD(track:(NSString *)eventName properties:(NSDictionary *)properties)
{
  if (eventName) {
    [[SnapyrSDK sharedSDK] track:eventName properties:properties];
  }
}

RCT_EXPORT_METHOD(reset)
{
  [[SnapyrSDK sharedSDK] reset];
}

@end
