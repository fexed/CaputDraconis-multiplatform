//
//  ArcadeModeWindow.swift
//  Caput_Draconis
//
//  Created by Federico Matteoni on 02/12/22.
//  Copyright © 2022 fexed. All rights reserved.
//

import SwiftUI
import expelliarmus
import FirebaseCore
import FirebaseAnalytics

struct ArcadeModeWindow: View {
    var spellList = iOSSpellsLoader().LoadSpells()
    @State var currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: iOSSpellsLoader().LoadSpells())
    @State var currentPoints = 0
    @State var currentErrors = 0
    @State var currentMessage = ""
    @Environment(\.presentationMode) var mode: Binding<PresentationMode>
    
    var body: some View {
        DuelLayout(
            spell: currentSpell,
            FiniteAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Finite")) {
                    currentMessage = NSLocalizedString("corretto", comment: "")
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    currentMessage = NSLocalizedString("sbagliato", comment: "") + " " + currentSpell.difinc
                    currentErrors += 1
                    if (currentErrors == 3) {
                        self.mode.wrappedValue.dismiss()
                    } else {
                        DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                        currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                    }
                }
            },
            ProtegoAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Protego")) {
                    currentMessage = NSLocalizedString("corretto", comment: "")
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    currentMessage = NSLocalizedString("sbagliato", comment: "") + " " + currentSpell.difinc
                    currentErrors += 1
                    if (currentErrors == 3) {
                        self.mode.wrappedValue.dismiss()
                    } else {
                        DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                        currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                    }
                }},
            ScutumAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Scutum")) {
                    currentMessage = NSLocalizedString("corretto", comment: "")
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    currentMessage = NSLocalizedString("sbagliato", comment: "") + " " + currentSpell.difinc
                    currentErrors += 1
                    if (currentErrors == 3) {
                        self.mode.wrappedValue.dismiss()
                    } else {
                        DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                        currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                    }
                }},
            Bottom: {
                VStack {
                    Text(currentMessage).padding().font(.footnote)
                    HStack {
                        Text("currentpoints").padding()
                        Text(String(currentPoints)).padding()
                    }
                    HStack {
                        Text("currenterrors").padding()
                        Text(String(currentErrors)).padding()
                    }
                }
            }
        )
        .onAppear {
            Analytics.logEvent(expelliarmus.Keys.companion.KEY_GAMEOPEN,
                               parameters: [:])
            Analytics.logEvent(expelliarmus.Keys.companion.KEY_ARCADE,
                               parameters: [:])
        }
    }
}
