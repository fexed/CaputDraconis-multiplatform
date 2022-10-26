//
//  UserDefaultsUtils.swift
//  Caput_Draconis
//
//  Created by Federico Matteoni on 26/10/22.
//  Copyright © 2022 fexed. All rights reserved.
//

import Foundation

class UserDefaultsUtils {
    static var shared = UserDefaultsUtils()
    
    func setDarkMode(enable: Bool) {
        UserDefaults.standard.set(enable, forKey: Constants.DARK_MODE)
    }
    
    func getDarkMode() -> Bool {
        UserDefaults.standard.bool(forKey: Constants.DARK_MODE)
    }
}
