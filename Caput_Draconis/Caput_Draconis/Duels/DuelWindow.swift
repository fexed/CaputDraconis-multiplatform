//
//  DuelWindow.swift
//  Caput_Draconis
//
//  Created by Federico Matteoni on 06/11/22.
//  Copyright © 2022 fexed. All rights reserved.
//

import SwiftUI
import expelliarmus

struct DuelWindow: View {
    var body: some View {
        MainMenu()
    }
}

struct MainMenu: View {
    let totalspells = DuelUtility.companion.getTotalSpellsNumber(prefs: NSObject())
    @State private var survivalModeSelected = false
    @State private var arcadeModeSelected = false
    @State private var timerlModeSelected = false
    
    var body: some View {
        NavigationLink(destination: SurvivalModeWindow(), isActive: $survivalModeSelected) {}
        //NavigationLink(destination: ArcadeModeWindow(), isActive: $arcadeModeSelected) {}
        //NavigationLink(destination: TimerModeWindow(), isActive: $timerlModeSelected) {}
        
        
        VStack {
            Text(NSLocalizedString("minigame", comment: "")).font(.title).padding()
            HStack {
                Text(NSLocalizedString("incnumb", comment: "")).padding()
                Spacer()
                Text(String(totalspells)).padding()
            }.padding()
            Text(NSLocalizedString("selectmode", comment: "")).font(.headline)
            ModeCard(title: NSLocalizedString("survmode", comment: ""), desc: NSLocalizedString("survmodedesc", comment: ""), buttontxt: NSLocalizedString("play", comment: "")) {
                survivalModeSelected = true
            }
            ModeCard(title: NSLocalizedString("arcademode", comment: ""), desc: NSLocalizedString("arcademodedesc", comment: ""), buttontxt: NSLocalizedString("play", comment: "")) {
                arcadeModeSelected = true
            }
//            ModeCard(title: NSLocalizedString("timermode", comment: ""), desc: NSLocalizedString("timermodedesc", comment: ""), buttontxt: NSLocalizedString("play", comment: "")) {
//                timerlModeSelected = true
//            }
            Spacer()
            SwiftUIBannerAd(adPosition: .bottom, adUnitId: "ca-app-pub-3940256099942544/2934735716")
        }
    }
}

struct ModeCard: View {
    var title: String
    var desc: String
    var buttontxt: String
    var action: () -> Void
    
    var body: some View {
        VStack {
            Text(title).font(.headline)
            Text(desc).font(.body).multilineTextAlignment(.center).fixedSize(horizontal: false, vertical: true)
            Button(action: action, label: {Text(buttontxt)}).padding()
        }.padding()

    }
}
