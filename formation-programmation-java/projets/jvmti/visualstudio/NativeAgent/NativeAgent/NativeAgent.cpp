// NativeAgent.cpp : définit les fonctions exportées pour l'application DLL.
//
#include <jvmti.h>

#include "stdafx.h"
#include "NativeAgent.h"
#include <iostream>


// Il s'agit d'un exemple de variable exportée
NATIVEAGENT_API int nNativeAgent = 0;

// Il s'agit d'un exemple de fonction exportée.
NATIVEAGENT_API int fnNativeAgent(void)
{
	return 42;
}

// Il s'agit du constructeur d'une classe qui a été exportée.
// consultez NativeAgent.h pour la définition de la classe
CNativeAgent::CNativeAgent()
{
	return;
}

typedef struct {
	jvmtiEnv *jvmti;
} GlobalAgentData;

static GlobalAgentData *gdata;

NATIVEAGENT_API jint JNICALL test(int a)
{
	return JNI_OK;
}

extern "C"
JNIEXPORT void JNICALL vmObjectAllocCallback
(jvmtiEnv *jvmti_env,
	JNIEnv* jni_env,
	jthread thread,
	jobject object,
	jclass object_klass,
	jlong size)
{
	printf("object allocation %08x, class: %08x, size:%d, thread:%08x\n", object, object_klass, size, thread);
}

extern "C"
JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
	jvmtiEnv *jvmti = NULL;
	jvmtiCapabilities capa;
	jvmtiError error;

	jint result = jvm->GetEnv((void **)&jvmti, JVMTI_VERSION_1_1);
	if (result != JNI_OK) {
		printf("ERROR: Unable to access JVMTI!\n");
	}

	(void)memset(&capa, 0, sizeof(jvmtiCapabilities));
	capa.can_tag_objects = 1;
	capa.can_generate_vm_object_alloc_events = 1;
	error = (jvmti)->AddCapabilities(&capa);

	jvmtiEventCallbacks eventCallbacks;
	memset(&eventCallbacks, 0, sizeof(eventCallbacks));
	eventCallbacks.VMObjectAlloc = &vmObjectAllocCallback;
	jvmti->SetEventCallbacks(&eventCallbacks, sizeof(eventCallbacks));

	jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_VM_OBJECT_ALLOC, NULL);

	printf("I AM A JVMTI Agent !\n");

	gdata = (GlobalAgentData*)malloc(sizeof(GlobalAgentData));
	gdata->jvmti = jvmti;
	return JNI_OK;
}


extern "C"
JNIEXPORT jint JNICALL objectCountingCallback(jlong class_tag, jlong size, jlong* tag_ptr, jint length, void* user_data)
{
	printf("\tobject tag:%08x, size:%d, tag:%08x\n", class_tag, size, tag_ptr);

	int* count = (int*)user_data;
	*count += 1;
	return JVMTI_VISIT_OBJECTS;
}

extern "C"
JNIEXPORT jvmtiIterationControl JNICALL heapObjectCallback(jlong class_tag, jlong size, jlong* tag_ptr, void* user_data)
{
	printf("\tobject tag:%08x, size:%d, tag:%08x\n", class_tag, size, tag_ptr);
	return JVMTI_ITERATION_CONTINUE;
}

extern "C"
JNIEXPORT jint JNICALL Java_Main_countInstances(JNIEnv *env, jclass thisClass, jclass klass)
{
	printf("Beginning counting instances...\n");
	int count = 0;
	jvmtiHeapCallbacks callbacks;
	(void)memset(&callbacks, 0, sizeof(callbacks));
	callbacks.heap_iteration_callback = &objectCountingCallback;
	jvmtiError error = gdata->jvmti->IterateThroughHeap(0, klass, &callbacks, &count);
	printf("done\n");

	jvmtiHeapObjectCallback cbs;
	(void)memset(&cbs, 0, sizeof(cbs));

	printf("\n\niterate over heap\n");

	//gdata->jvmti->IterateOverHeap(JVMTI_HEAP_OBJECT_EITHER, &heapObjectCallback, NULL);
	return count;
}
