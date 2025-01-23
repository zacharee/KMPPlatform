#include <windef.h>

BOOL IsWow64Process2(
        HANDLE hProcess,
        USHORT *pProcessMachine,
        USHORT *pNativeMachine
);
