// Le bloc ifdef suivant est la façon standard de créer des macros qui facilitent l'exportation 
// à partir d'une DLL. Tous les fichiers contenus dans cette DLL sont compilés avec le symbole NATIVEAGENT_EXPORTS
// défini sur la ligne de commande. Ce symbole ne doit pas être défini pour un projet
// qui utilisent cette DLL. De cette manière, les autres projets dont les fichiers sources comprennent ce fichier considèrent les fonctions 
// NATIVEAGENT_API comme étant importées à partir d'une DLL, tandis que cette DLL considère les symboles
// définis avec cette macro comme étant exportés.
#ifdef NATIVEAGENT_EXPORTS
#define NATIVEAGENT_API __declspec(dllexport)
#else
#define NATIVEAGENT_API __declspec(dllimport)
#endif

// Cette classe est exportée de NativeAgent.dll
class NATIVEAGENT_API CNativeAgent {
public:
	CNativeAgent(void);
	// TODO: ajoutez ici vos méthodes.
};

extern NATIVEAGENT_API int nNativeAgent;

NATIVEAGENT_API int fnNativeAgent(void);
