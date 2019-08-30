import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaSharedModule } from 'app/shared';
import { KarmaAdminModule } from 'app/admin/admin.module';
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
  imports: [KarmaSharedModule, KarmaAdminModule, RouterModule.forChild(ENTITY_STATES)],
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
export class KarmaRegisteredUserModule {}
