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
                Image("cd_logo")
                Group {
                    Text(NSLocalizedString("ideazioneesviluppotext", comment: "")).font(.headline)
                    Text("Federico Matteoni").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("graficatext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Saverio Landini\nMartina Crucianelli").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("ideazionegiocotext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Saverio Landini").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("sceltaincantesimitext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Saverio Landini\nMatteo Mascagni\nJacopo Di Vito\n(Team Duelli)").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("fontieformuletext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Jacopo Di Vito").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("effettiecontrtext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Matteo Mascagni").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("supportoconsulenzatext", comment: "")).font(.headline).multilineTextAlignment(.center)
                    Text("Mattia Coreno\nEleonora Ugolini").font(.body).multilineTextAlignment(.center)
                }.padding(.bottom)
                
                Group {
                    Text(NSLocalizedString("graziedirettivotext", comment: "")).font(.body).multilineTextAlignment(.leading).frame(
                        minWidth: 0,
                        maxWidth: .infinity,
                        alignment: .topLeading
                      )
                    Text(NSLocalizedString("grazieragazzitext", comment: "")).font(.body).multilineTextAlignment(.leading).frame(
                        minWidth: 0,
                        maxWidth: .infinity,
                        alignment: .topLeading
                      )
                    Text(.init(NSLocalizedString("cdfacebook", comment: ""))).font(.body).multilineTextAlignment(.leading).frame(
                        minWidth: 0,
                        maxWidth: .infinity,
                        alignment: .topLeading
                      )
                    Text(.init(NSLocalizedString("cdwebsite", comment: ""))).font(.body).multilineTextAlignment(.leading).frame(
                        minWidth: 0,
                        maxWidth: .infinity,
                        alignment: .topLeading
                      )
                    Text(NSLocalizedString("disclaimer", comment: "")).font(.body).multilineTextAlignment(.leading).frame(
                        minWidth: 0,
                        maxWidth: .infinity,
                        alignment: .topLeading
                      )
                    Text(vers).font(.body).multilineTextAlignment(.leading)
                }.padding(.bottom)
            }
        }.navigationBarTitle(Text(NSLocalizedString("credits", comment: "")), displayMode:.automatic)
    }
}
