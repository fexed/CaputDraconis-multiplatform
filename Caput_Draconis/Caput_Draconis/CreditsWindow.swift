//
//  CreditsWindow.swift
//  Caput_Draconis
//
//  Created by Federico Matteoni on 25/10/22.
//  Copyright © 2022 fexed. All rights reserved.
//

import SwiftUI
import expelliarmus

struct CreditsWindow: View {
    let vers = PlatformKt.getPlatform().getVersion()
    
    var body: some View {
        List {
            VStack {
                Group {
                    Text(NSLocalizedString("ideazioneesviluppotext", comment: "")).font(.headline)
                    Text("Federico Matteoni").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("graficatext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Saverio Landini\nMartina Crucianelli").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("ideazionegiocotext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Saverio Landini").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("sceltaincantesimitext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Saverio Landini\nMatteo Mascagni\nJacopo Di Vito\n(Team Duelli)").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("fontieformuletext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Jacopo Di Vito").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("effettiecontrtext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Matteo Mascagni").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("supportoconsulenzatext", comment: "")).font(.headline).multilineTextAlignment(.leading)
                    Text("Mattia Coreno\nEleonora Ugolini").font(.body)
                }.padding()
                
                Group {
                    Text(NSLocalizedString("graziedirettivotext", comment: "")).font(.body).multilineTextAlignment(.leading)
                    Text(NSLocalizedString("grazieragazzitext", comment: "")).font(.body).multilineTextAlignment(.leading)
                    Text(NSLocalizedString("disclaimer", comment: "")).font(.body).multilineTextAlignment(.leading)
                    Text(vers).font(.body).multilineTextAlignment(.leading)
                }.padding()
            }
        }.navigationBarTitle(Text(NSLocalizedString("credits", comment: "")), displayMode:.automatic)
    }
}
