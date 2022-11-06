import SwiftUI
import AppTrackingTransparency
import GoogleMobileAds

@main
struct iOSApp: App {
    init() {
        if ATTrackingManager.trackingAuthorizationStatus == .notDetermined {
            //tracking not granted
        } else {
            ATTrackingManager.requestTrackingAuthorization { status in
                GADMobileAds.sharedInstance().start(completionHandler: nil)
            }
        }
    }
    
	var body: some Scene {
		WindowGroup {
			SpellListWindow()
		}
        
        WindowGroup("Credits") {
            CreditsWindow()
        }.handlesExternalEvents(matching: Set(arrayLiteral: "Credits"))
        
        WindowGroup("Duel") {
            DuelWindow()
        }.handlesExternalEvents(matching: Set(arrayLiteral: "Duel"))
	}
}
