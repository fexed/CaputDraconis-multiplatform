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
    let spellList = iOSSpellsLoader().LoadSpells()
    
    var body: some View {
        Text(SpellListUtility.companion.GetRandomSpell(spellList: spellList).nome)
    }
}
