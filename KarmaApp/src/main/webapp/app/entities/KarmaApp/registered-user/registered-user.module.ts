import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaAppSharedModule } from 'app/shared';
import { KarmaAppAdminModule } from 'app/admin/admin.module';
import {
  RegisteredUserComponent,
  RegisteredUserDetailComponent,
  RegisteredUserUpdateComponent,
  RegisteredUserDeletePopupComponent,
  RegisteredUserDeleteDialogComponent,
  registeredUserRoute,
  registeredUserPopupRoute
} from './';

const ENTITY_STATES = [...registeredUserRoute, ...registeredUserPopupRoute];

@NgModule({
  imports: [KarmaAppSharedModule, KarmaAppAdminModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    RegisteredUserComponent,
    RegisteredUserDetailComponent,
    RegisteredUserUpdateComponent,
    RegisteredUserDeleteDialogComponent,
    RegisteredUserDeletePopupComponent
  ],
  entryComponents: [
    RegisteredUserComponent,
    RegisteredUserUpdateComponent,
    RegisteredUserDeleteDialogComponent,
    RegisteredUserDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaAppRegisteredUserModule {}
