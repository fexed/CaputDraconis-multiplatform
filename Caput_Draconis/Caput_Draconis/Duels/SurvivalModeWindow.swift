//
//  SurvivalModeWindow.swift
//  Caput_Draconis
//
//  Created by Federico Matteoni on 06/11/22.
//  Copyright © 2022 fexed. All rights reserved.
//

import SwiftUI
import expelliarmus

struct SurvivalModeWindow: View {
    var spellList = iOSSpellsLoader().LoadSpells()
    @State var currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: iOSSpellsLoader().LoadSpells())
    @State var currentPoints = 0
    @Environment(\.presentationMode) var mode: Binding<PresentationMode>
    
    var body: some View {
        DuelLayout(
            spell: currentSpell,
            FiniteAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Finite")) {
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    self.mode.wrappedValue.dismiss()
                }
            },
            ProtegoAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Protego")) {
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    self.mode.wrappedValue.dismiss()
                }},
            ScutumAction: {
                if (checkSpell(currentSpell: currentSpell, defensiveSpell: "Scutum")) {
                    DuelUtility.companion.incrTotalSpellsNumber(prefs: NSObject())
                    currentPoints += 1
                    currentSpell = SpellListUtility.companion.GetRandomSpell(spellList: spellList)
                } else {
                    self.mode.wrappedValue.dismiss()
                }}
        )
    }
}
