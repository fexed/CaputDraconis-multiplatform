import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			SpellListWindow()
		}
        
        WindowGroup("Credits") {
            CreditsWindow()
        }.handlesExternalEvents(matching: Set(arrayLiteral: "Credits"))
	}
}
