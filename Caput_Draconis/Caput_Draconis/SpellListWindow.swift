import SwiftUI
import GoogleMobileAds
import FirebaseCore
import FirebaseAnalytics
import expelliarmus

struct iOSSpell: Identifiable {
    let id: UUID
    let nome: String
    let descrizione: String
    let difinc: String
    let categoria: String
    let fonte: String
    
}

func loadSpells(spells: [Spell]) -> [iOSSpell] {
    var outputList = [iOSSpell]()
    spells.forEach { spell in
        outputList.append(getIOSSpell(spell: spell))
    }
    
    return outputList
}

func getIOSSpell(spell: Spell) -> iOSSpell {
    return iOSSpell(id: UUID(), nome: spell.nome, descrizione: spell.descrizione, difinc: spell.difinc, categoria: spell.categoria, fonte: spell.fonte)
}

struct SpellListWindow: View {
    @State private var isShowingCreditsWindow = false
    @State private var isShowingDuelWindow = false
    @State private var iosspells = loadSpells(spells: iOSSpellsLoader().LoadSpells())
    @State private var query = ""
    
    var body: some View {
        let spells = iOSSpellsLoader().LoadSpells()
        let _ = getIOSSpell(spell: SpellsLoaderCompanion().ProtegoSpell)
        let _ = getIOSSpell(spell: SpellsLoaderCompanion().ScutumSpell)
        let _ = getIOSSpell(spell: SpellsLoaderCompanion().FiniteSpell)
        
        NavigationView {
            ZStack {
                List {
                    ForEach(loadSpells(spells: SpellListUtility.companion.Search(query: query, spellList: spells))) { iosspell in
                        SpellElement(spell: iosspell)
                    }
                }
                .navigationTitle("appname")
                .toolbar() {
                    ToolbarItem() {
                        NavigationLink(destination: CreditsWindow(), isActive: $isShowingCreditsWindow) {
                            Button {
                                isShowingCreditsWindow = true
                            } label: {
                                Image(systemName: "info")
                            }
                        }
                    }
                }
                .searchable(text: $query, prompt: "search")
                .padding(.bottom, 16)
                
                SwiftUIBannerAd(adPosition: .bottom, adUnitId: "ca-app-pub-3940256099942544/2934735716")
                
                VStack {
                    Spacer()
                    HStack {
                        Spacer()
                        NavigationLink(destination: DuelWindow(), isActive: $isShowingDuelWindow) {
                            Button {
                                isShowingDuelWindow = true
                            } label: {
                                Text(NSLocalizedString("minigame", comment: ""))
                                    .font(.system(.footnote))
                                    .foregroundColor(Color.white)
                                    .padding(16)
                            }
                        }
                        
                        .background(Color.blue)
                        .cornerRadius(38.5)
                        .padding()
                    }
                }
                .padding(.bottom, 16)
            }
        }
        .navigationViewStyle(.stack)
        .onAppear {
            Analytics.logEvent(expelliarmus.Keys.companion.KEY_APPOPEN,
                               parameters: [:])
        }
    }
}

struct SpellElement: View {
    var spell: iOSSpell
    
    @State private var showSpellDialog = false
    
    var body: some View {
        VStack {
            HStack {
                Text(spell.nome).font(.headline).multilineTextAlignment(.leading)
                Spacer()
            }
            HStack {
                Text(spell.categoria).font(.footnote).multilineTextAlignment(.leading)
                Spacer()
                Text(spell.fonte).font(.caption).multilineTextAlignment(.trailing)
            }
        }.onTapGesture {
            showSpellDialog.toggle()
        }.sheetWithDetents(isPresented: $showSpellDialog,
                           detents: [.medium()]) {} content: {
            SpellDialog(spell: spell)
        }
    }
}

struct SpellDialog: View {
    var spell: iOSSpell
    
    var body: some View {
        VStack {
            Text(spell.nome).font(.title).bold().multilineTextAlignment(.leading).padding(.leading, 16).frame(maxWidth: .infinity, alignment: .leading)
            Text(NSLocalizedString("category", comment: "") + ": " + spell.categoria).font(.footnote).multilineTextAlignment(.leading).padding(.leading, 16).frame(maxWidth: .infinity, alignment: .leading)
            Text(NSLocalizedString("defensivespell", comment: "") + ": " + spell.difinc).font(.footnote).multilineTextAlignment(.leading).padding(.leading, 16).frame(maxWidth: .infinity, alignment: .leading)
            Text(spell.descrizione).font(.body).multilineTextAlignment(.leading).padding().frame(maxWidth: .infinity, alignment: .leading)
            HStack {
                Spacer()
                Text(NSLocalizedString("source", comment: "") + ": " + spell.fonte).font(.caption).multilineTextAlignment(.trailing).padding(.trailing, 16)
            }
            
        }
    }
}

// 1 - Create a UISheetPresentationController that can be used in a SwiftUI interface
struct SheetPresentationForSwiftUI<Content>: UIViewRepresentable where Content: View {
    
    @Binding var isPresented: Bool
    let onDismiss: (() -> Void)?
    let detents: [UISheetPresentationController.Detent]
    let content: Content
    
    
    init(
        _ isPresented: Binding<Bool>,
        onDismiss: (() -> Void)? = nil,
        detents: [UISheetPresentationController.Detent] = [.medium()],
        @ViewBuilder content: () -> Content
    ) {
        self._isPresented = isPresented
        self.onDismiss = onDismiss
        self.detents = detents
        self.content = content()
    }
    
    func makeUIView(context: Context) -> UIView {
        let view = UIView()
        return view
    }
    
    func updateUIView(_ uiView: UIView, context: Context) {
        
        // Create the UIViewController that will be presented by the UIButton
        let viewController = UIViewController()
        
        // Create the UIHostingController that will embed the SwiftUI View
        let hostingController = UIHostingController(rootView: content)
        
        // Add the UIHostingController to the UIViewController
        viewController.addChild(hostingController)
        viewController.view.addSubview(hostingController.view)
        
        // Set constraints
        hostingController.view.translatesAutoresizingMaskIntoConstraints = false
        hostingController.view.leftAnchor.constraint(equalTo: viewController.view.leftAnchor).isActive = true
        hostingController.view.topAnchor.constraint(equalTo: viewController.view.topAnchor).isActive = true
        hostingController.view.rightAnchor.constraint(equalTo: viewController.view.rightAnchor).isActive = true
        hostingController.view.bottomAnchor.constraint(equalTo: viewController.view.bottomAnchor).isActive = true
        hostingController.didMove(toParent: viewController)
        
        // Set the presentationController as a UISheetPresentationController
        if let sheetController = viewController.presentationController as? UISheetPresentationController {
            sheetController.detents = detents
            sheetController.prefersGrabberVisible = true
            sheetController.prefersScrollingExpandsWhenScrolledToEdge = false
            sheetController.largestUndimmedDetentIdentifier = .medium
        }
        
        // Set the coordinator (delegate)
        // We need the delegate to use the presentationControllerDidDismiss function
        viewController.presentationController?.delegate = context.coordinator
        
        
        if isPresented {
            // Present the viewController
            uiView.window?.rootViewController?.present(viewController, animated: true)
        } else {
            // Dismiss the viewController
            uiView.window?.rootViewController?.dismiss(animated: true)
        }
        
    }
    
    /* Creates the custom instance that you use to communicate changes
    from your view controller to other parts of your SwiftUI interface.
     */
    func makeCoordinator() -> Coordinator {
        Coordinator(isPresented: $isPresented, onDismiss: onDismiss)
    }
    
    class Coordinator: NSObject, UISheetPresentationControllerDelegate {
        @Binding var isPresented: Bool
        let onDismiss: (() -> Void)?
        
        init(isPresented: Binding<Bool>, onDismiss: (() -> Void)? = nil) {
            self._isPresented = isPresented
            self.onDismiss = onDismiss
        }
        
        func presentationControllerDidDismiss(_ presentationController: UIPresentationController) {
            isPresented = false
            if let onDismiss = onDismiss {
                onDismiss()
            }
        }
        
    }
    
}

// 2 - Create the SwiftUI modifier conforming to the ViewModifier protocol
struct sheetWithDetentsViewModifier<SwiftUIContent>: ViewModifier where SwiftUIContent: View {
    
    @Binding var isPresented: Bool
    let onDismiss: (() -> Void)?
    let detents: [UISheetPresentationController.Detent]
    let swiftUIContent: SwiftUIContent
    
    init(isPresented: Binding<Bool>, detents: [UISheetPresentationController.Detent] = [.medium()] , onDismiss: (() -> Void)? = nil, content: () -> SwiftUIContent) {
        self._isPresented = isPresented
        self.onDismiss = onDismiss
        self.swiftUIContent = content()
        self.detents = detents
    }
    
    func body(content: Content) -> some View {
        ZStack {
            SheetPresentationForSwiftUI($isPresented,onDismiss: onDismiss, detents: detents) {
                swiftUIContent
            }.fixedSize()
            content
        }
    }
}

// 3 - Create extension on View that makes it easier to use the custom modifier
extension View {
    
    func sheetWithDetents<Content>(
        isPresented: Binding<Bool>,
        detents: [UISheetPresentationController.Detent],
        onDismiss: (() -> Void)?,
        content: @escaping () -> Content) -> some View where Content : View {
            modifier(
                sheetWithDetentsViewModifier(
                    isPresented: isPresented,
                    detents: detents,
                    onDismiss: onDismiss,
                    content: content)
            )
        }
}
